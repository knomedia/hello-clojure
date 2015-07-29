(defproject hello-clojure "0.1.0-SNAPSHOT"
  :description "a quick run through of clojure, ring, and docker"
  :url "https://github.com/knomedia/hello-clojure"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.8"]
                 [ring/ring-devel "1.1.8"]
                 [ring/ring-core "1.1.8"]
                 [ring/ring-json "0.3.1"]
                 [cheshire "5.5.0"]
                 [http-kit "2.1.6"]]
  :main hello-clojure.core)
