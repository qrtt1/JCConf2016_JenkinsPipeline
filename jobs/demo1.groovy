node {
    stage ('checkout') {
        echo 'checkout from git'
    }
    stage ('build') {
        echo 'build'
    }
    stage ('test') {
        echo 'test'
    }
    stage ('war') {
        echo 'war'
    }
}
