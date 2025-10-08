pipeline {
  agent any

  environment {
    ANDROID_HOME = "/opt/android-sdk"
    PATH = "${env.PATH}:${ANDROID_HOME}/cmdline-tools/latest/bin:${ANDROID_HOME}/platform-tools"
    GRADLE_USER_HOME = "${WORKSPACE}/.gradle"
  }

  options {
    timestamps()
    buildDiscarder(logRotator(numToKeepStr: '10'))
  }

  stages {
    stage('Checkout') {
      steps {
        // if Jenkins pulls from SCM automatically this is optional; kept for clarity
        checkout([$class: 'GitSCM',
          branches: [[name: '*/master']],
          userRemoteConfigs: [[url: 'https://github.com/kamydeep00178/MultiModule.git']]
        ])
      }
    }

    stage('Show env') {
      steps {
        sh 'echo "ANDROID_HOME=$ANDROID_HOME"'
        sh 'which sdkmanager || true'
        sh 'sdkmanager --list | head -n 20 || true'
        sh 'java -version || true'
      }
    }

    stage('Ensure SDK & Licenses') {
      steps {
        sh '''
          export ANDROID_HOME="${ANDROID_HOME}"
          export PATH="${PATH}"
          yes | sdkmanager --licenses
          sdkmanager "platform-tools" "platforms;android-34" "build-tools;34.0.0" || true
        '''
      }
    }

    stage('Build') {
      steps {
        sh '''
          if [ -x "./gradlew" ]; then
            chmod +x ./gradlew
            ./gradlew clean assembleDebug --no-daemon --stacktrace
          else
            gradle clean assembleDebug --no-daemon --stacktrace
          fi
        '''
      }
    }

    stage('Archive APK') {
      steps {
        // adjust glob if module name differs (e.g. myapp)
        archiveArtifacts artifacts: 'app/build/outputs/**/*.apk', fingerprint: true
      }
    }
  }

  post {
    success { echo "Build succeeded" }
    failure { echo "Build failed - check console output" }
  }
}