(ns jp.blackawa.bbq-rum.raw
  (:require [com.stuartsierra.component :as component]
            [figwheel-sidecar.system :refer [figwheel-system fetch-config]]))

(defn system []
  (component/system-map
   :figwheel (figwheel-system (fetch-config))))
