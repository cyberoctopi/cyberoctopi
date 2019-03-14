(ns cyberoctopi.system
  (:require [com.stuartsierra.component :as component]))


(defn initialize-system-d
  "Initializes development system
  :config to pull in configuration files if necessary
  :pedestal to start pedestal components"
  [config]
  (component/system-map ;; TODO: Take time and look over component system map examples then see how to tie in pedestal and an in memory db for now.
   :config config
   :pedestal (;;component/using...
              )))

