(ns clj-spec-instrument.core
  (:require [clojure.spec.alpha :as s]
            [clojure.spec.test.alpha :as stest])
  (:gen-class))

(defn ranged-rand
  "Returns random int in range start <= rand < end"
  [start end]
  (+ start (long (rand (- end start)))))

(s/fdef ranged-rand
  :args (s/and (s/cat :start int? :end int?)))

(s/fdef ranged-rand
  :args (s/and (s/cat :start int? :end int?)
               #(< (:start %) (:end %))))

(def should-instrument
  (read-string (or (System/getenv "SHOULD_INSTRUMENT")
                   "true")))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (if should-instrument
    (stest/instrument `ranged-rand))
  (println (ranged-rand 8 5))
  (println (ranged-rand 'c' 5)))
