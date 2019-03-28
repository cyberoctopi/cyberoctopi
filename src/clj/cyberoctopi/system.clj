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

(reloaded.repl/set-init! #(system :prod))
;; (defn initialize-system-d
;;   "Initializes development system
;;   :config to pull in configuration files if necessary
;;   :pedestal to start pedestal components"
;;   [config]
;;   (component/system-map ;; TODO: Take time and look over component system map examples then see how to tie in pedestal and an in memory db for now.
;;    :config config
;;    :pedestal (;;component/using...
;;               )))

