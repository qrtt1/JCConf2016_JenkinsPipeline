node {
    def job = "build"
    def war = "jenkins-sample-project.war"
    def deployPath = "/Users/qrtt1/temp/JenkinsPipelineKata/apache-tomcat-8.5.6/webapps"
    stage ('Deploy') {
        sh "rm -f *.war"
        step ([$class: 'CopyArtifact',
              projectName: "$job",
              filter: '**/*.war', flatten: true])

        sh "cp $war $deployPath/Demo##${BUILD_NUMBER}.war"
    }
}
