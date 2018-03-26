(ns jp.blackawa.bbq-rum.client
  (:require [rum.core :as rum]))

;; You can print things to browser console by (println xxx).
(enable-console-print!)

;; Check your browser console and you will see a same message.
(println "Hello from cljs! :)")

(def state (atom {:count 0}))

(rum/defc +counter < rum/reactive [state]
  [:.card
   [:.card-content
    [:h2.title.is-4 "Current count:" (:count (rum/react state))]
    [:button.button.is-success {:on-click #(swap! state update-in [:count] inc)} "Increment++"]]])

(rum/defc +app [state]
  [:.content
   [:h1.title "Welcome to Rum world!"]
   (+counter state)])

(when-let [app (js/document.getElementById "app")]
  (rum/mount (+app state) app))
