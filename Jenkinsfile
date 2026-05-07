pipeline {
	    agent any

	//agent { label 'windows' }   // Ensures it runs on Windows
tools {
    maven 'MAVEN_HOME'
    jdk 'JAVA_HOME'
}
parameters {
    string(name: 'runnerFileName', defaultValue: 'testng.xml', description: 'Here we specify the name of testng.xml runner file which need to executed')
    choice(name: 'browserName', choices: ['chrome', 'firefox', 'edge'], description: 'CHROME,FIREFOX,EDGE Tests should be executed only in these browser platforms')
    booleanParam(name: 'browserHeadless', defaultValue: false, description: 'browserHeadless : is to specify the headed more or not in execution cycle')
    booleanParam(name: 'browserPrivate', defaultValue: false, description: 'browserPrivate is used to run in private mode or not')
    }
stages {
    stage('Clean Workspace') {
        steps {
            cleanWs()
        }
    }
    stage('Checkout Code') {
        steps {
            git branch: 'master', url: 'https://github.com/sannapparashmi-ctrl/Jenkins_Repo.git'
        }
    }
    stage('Build Project') {
        steps {
            bat 'mvn clean compile'
        }
    }
    stage('Execute UI Tests') {
        steps {
            bat """
            mvn test -DrunnerFileName=%runnerFileName% -Dbrowser=%browserName% -Dheadless=%browserHeadlessMode% -Dprivate=%browserPrivateMode% 
            """
        }
    }
    stage('Re-run Failed Tests') {
        steps {
            script {
                def failedSuitePath = 'test-output/testng-failed.xml'

                if (!fileExists(failedSuitePath)) {
                    failedSuitePath = 'target/surefire-reports/testng-failed.xml'
                }

                if (fileExists(failedSuitePath)) {
                    echo "Re-running failed tests from: ${failedSuitePath}"

                    bat """
					mvn test ^
					-DsuiteXmlFile=${failedSuitePath} ^
					-Dbrowser=%browserName% ^
					-Dheadless=%headless% ^
					-Dprivate=%private%
					"""
                } else {
                    echo "No failed tests found"
                }
            }
        }
    }
    stage('Allure Report') {
        steps {
            allure includeProperties: false,
                   jdk: '',
                   results: [[path: 'target/allure-results']]
        }
    }
    stage('Archive Reports') {
        steps {
            archiveArtifacts artifacts: 'target/**/*', fingerprint: true
        }
    }
}
post {
    always {
        echo 'Execution Completed'
    }
    success {
        echo 'All Tests Passed ✅'
    }
    failure {
        echo 'Some Tests Failed ❌'
    }
}
}
