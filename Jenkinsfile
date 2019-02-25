node {
  // Mark the code checkout 'stage'....
  stage 'Stage Checkout'

  // Checkout code from repository and update any submodules
  checkout scm

  stage 'Stage Build'

  //branch name from Jenkins environment variables
  echo "My branch is:"


  //build your gradle flavor, passes the current build number as a parameter to gradle
  "./gradlew assembleDebug"
  "./gradlew assembleAndroidTest"

    stage 'Run Tests'
 bat "./scripts/run-tests.bat"


  stage 'Stage Archive'
  //tell Jenkins to archive the apks
  archiveArtifacts artifacts: 'app/build/outputs/apk/*.apk', fingerprint: true


   stage('Results') {
      junit '**/target/TEST.xml'
      archive 'target/*.jar'
   }


  stage 'Stage Upload To Fabric'
  sh "./gradlew clean"
}

// Pulls the android flavor out of the branch name the branch is prepended with /QA_
