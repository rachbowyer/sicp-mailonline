(ns sicp-clojure.gcd-test
  (:require [clojure.test :refer :all]
            [sicp-clojure.gcd :refer :all]))

(deftest gcd-test
  (testing "gcd"
    (is (= (gcd 40 206) 2))))