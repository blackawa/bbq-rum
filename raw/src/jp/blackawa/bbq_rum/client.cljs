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
   [:columns (+counter state)]])

(when-let [app (js/document.getElementById "app")]
  (rum/mount (+app state) app))
