(ns jp.blackawa.bbq-rum.client
  (:require [rum.core :as rum]))

;; See figwheel.edn for CLJS build configurations.

;; You can print things to browser console by (println xxx).
(enable-console-print!)

;; Check your browser console and you will see a same message.
(println "Hello from cljs! :)")

;; Manage state with this atom.
;; You can know about atom from https://clojuredocs.org/clojure.core/atom .
(def state (atom {:count 0}))

;; Rum component which is bidirectional binded.
;; See https://github.com/tonsky/rum for details.
(rum/defc +counter < rum/reactive [state]
  [:.card
   [:.card-content
    [:.navbar.is-light
     [:.navbar-brand
      [:a.navbar-item {:href "#"} "RumShop"]]
     [:.navbar-end
      [:a.navbar-item {:href "#"}
       [:span.icon [:i.fas.fa-shopping-cart]]
       [:span "Cart(" (:count (rum/react state)) ")"]]]]
    [:h2.title.is-4 "Lamb Chop 1kg"]
    [:button.button.is-success {:on-click #(swap! state update-in [:count] inc)} "Add to cart"]]])

(rum/defc +app [state]
  [:.content
   [:h1.title "Welcome to Rum world!"]
   ;; Rum can render other components like function call.
   [:columns (+counter state)]])

;; This script is evaluated when main.js is loaded.
(when-let [app (js/document.getElementById "app")]
  (rum/mount (+app state) app))
