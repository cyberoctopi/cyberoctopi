(ns cyberoctopi.system
  (:require [com.stuartsierra.component :as component]
            [reloaded.repl :refer [init start stop go reset]]
            [io.pedestal.http :as http]
            [cyberoctopi.routes :as routes]
            [cyberoctopi.pedestal :as pedestal]))



(defn system [env]
  (component/system-map
   :service-map
   {:env env
    ::http/routes routes/routes
    ::http/type :immutant
    ::http/port 8080
    ::http/join? false}

   :pedestal
   (component/using
    (pedestal/new-pedestal)
    [:service-map])))

;; (require 'cyberoctopi.system)
(reloaded.repl/set-init! #(system :prod))
(reloaded.repl/go) ()







