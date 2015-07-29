(ns hello-clojure.core
  (:require [compojure.core :refer :all]
            [ring.middleware.reload :as reload]
            [compojure.handler :refer [site]]
            [ring.middleware.json :refer [wrap-json-body]]
            [cheshire.core :refer :all]
            [org.httpkit.server :refer [run-server]]))

(defn sum-values "sum-values" [nums]
  (reduce + nums))

(defroutes app-routes
  (GET "/" []
       {:status 200
        :headers {"Content-Type" "application/json"}
        :body "Hey. POST JSON to /sum, with {\"numbers:\" [1,2,3,4]}"})
  (POST "/sum" req
        (let [numbers (or (get-in req [:body :numbers])
                          (get-in req [:params :numbers])
                          [])]
          (let [response {:numbers numbers
                          :sum (sum-values numbers)}]
            {:status 200
             :headers {"Content-Type" "application/json"}
             :body (generate-string response)}))))

(defn clojure-env []
  (or (get-in (System/getenv) ["CLOJURE_ENV"])
      "development"))

(defn -main []
  (println (str "Running in: " (clojure-env) " mode"))
  (let [handler (if (= (clojure-env) "production")
                  (wrap-json-body (site app-routes))
                  (reload/wrap-reload (wrap-json-body (site #'app-routes) {:keywords? true})))]
  (run-server handler {:port 3000})))
