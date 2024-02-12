# observability
Application to show how to scrape logs using grafana loki, and display it in grafan dashboard. Also metrics are scraped by prometheus and displayed in Grafana dashboard

[//]: # (Configuration for scraping docker logs)
1. First, download the loki driver for docker
```docker plugin install grafana/loki-docker-driver:latest --alias loki --grant-all-permissions```
2. Create a daemon.json file inside ```/etc/docker``` on linux or ```C:\ProgramData\docker\config``` 
on windows (when using docker desktop for windows). File content looks like
  ```
    {
      "debug": true,
      "log-driver": "loki",
      "log-opts": {
         "loki-url": "http://loki:3100/loki/api/v1/push",
         "loki-batch-size": 400
      }
    }
```
3. Restart the docker daemon. All newly created containers will start pushing logs to loki

4. Go to your Grafana dashboard and and a query with param ```{container_name}: docker_container_name```