# hello-clojure

setting up a quick docker + clojure service example. Takes a JSON package with an array of `numbers` and returns a sum of them.


## About

This is just a small exploration into a minimal clojure service. It utilizes
[http-kit](http://www.http-kit.org),
[compojure](https://github.com/weavejester/compojure), and some
[ring](https://github.com/ring-clojure/ring) middleware.


## Usage

These directions assume you have [`dinghy`](https://github.com/codekitchen/dinghy) setup (otherwise you'll need to do some inspecting to determine IP and port)

Start up the app
```bash
docker-compose build web
docker-compose run web
```

Hit the main endpoints:
```bash
curl http://hello-clojure.docker
```


POST to the `/sum` endpoint
```bash
curl -X POST http://hello-clojure.docker/sum \
  -d '{"numbers": [1,2,7]}' \
  --header "Content-type:application/json"
```


## License

Copyright © 2015 jmadsen

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
