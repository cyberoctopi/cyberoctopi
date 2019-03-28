(ns cyberoctopi.pedestal
  (:require [com.stuartsierra.component :as component]
            [io.pedestal.http :as http]))

(defn test? [service-map]
  (= :test (:env service-map)))

;;-- Pedestal Component -----------------------------------
;; Main component to get our Pedestal web server up and running

(defrecord Pedestal [service-map service]
  component/Lifecycle
  (start [this]
    (if service
      this
      (cond-> service-map
        true                      http/create-server
        (not (test? service-map)) http/start
        true                      ((partial assoc this :service)))))
  
  (stop [this]
    (when (and service (not (test? service-map)))
      (http/stop service))
    (assoc this :service nil)))

(defn new-pedestal []
  (map->Pedestal {}))
