(ns jp.blackawa.bbq-rum.flow
  "See http://slonoed.net/redux-in-closurescript-with-rum for details!
   This project learns a lot from that post."
  (:require [cljs.core.async :refer [<! chan put!]])
  (:require-macros [cljs.core.async :refer [go-loop]]))

(defonce state (atom {:count 0}))
(defonce actions (chan))

(defn dispatch
  ([type] (dispatch type nil))
  ([type data]
   (put! actions [type data])))

(defmulti transform
  (fn [state data dispatch action-type] action-type))

(defmethod transform :increment-count
  [state _value]
  (update-in state [:count] inc))

(go-loop []
  (when-let [a (<! actions)]
    (let [[type data] a]
      (swap! state transform data dispatch type))
    (recur)))
