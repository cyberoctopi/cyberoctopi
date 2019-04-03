(ns cyberoctopi.db
  (:require [clojure.spec.alpha :as s]))

(def default-db
  {:active-panel :front-page-panel
   :backend-url "/api"
   :logged-in? false})
