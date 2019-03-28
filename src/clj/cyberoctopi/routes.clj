(ns cyberoctopi.routes
  (:require [io.pedestal.http.route.definition :refer [defroutes]]
            [clojure.java.io :as io]))
 



(defn hello-octopi [_]
  {:status 200 :body "Initializing Cyberoctopi!"})

(def routes
  #{["/octopi" :get hello-octopi :route-name :octopi]})
;; (defn index [_]
;;   {:status 200
;;    :headers {"Content-Type" "text/html"}
;;    :body (io/file "resources/public/index.html")})
