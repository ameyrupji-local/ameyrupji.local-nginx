node {
    stage('Nginx Information') {
        sh '''
            /usr/local/bin/nginx -v
        '''
    }
    
    stage('Nginx Stop') {
        sh '''
            status=$(curl -s -o /dev/null -w "%{http_code}" "http://ameyrupji.local/")
            echo $status
            if [[ "$status" -eq 200 ]]; then 
                echo "Stopping Nginx!"
                /usr/local/bin/nginx -s stop
            fi
            
        '''
    }

    stage('Nginx Start') {
        sh '''
            /usr/local/bin/nginx
        '''
    }
}   