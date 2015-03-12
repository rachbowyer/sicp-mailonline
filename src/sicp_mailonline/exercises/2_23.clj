;; Exercise 2.23
;; The procedure for-each is similar to map.  It takes as arguments a procedure
;; and a list of elements.  However, rather than forming a list of the results,
;; for-each just applies the procedure to each of the elements in turn, from
;; left to right.  The values returned by applying the procedure to the elements
;; are not used at all - for-each is used with procedures that perform an action,
;; such as printing.  For example,
;;
;;  (for-each (lambda (x) (newline) (display x))
;;            (list 57 321 88))
;;
;; => 57
;;    321
;;    88
;;
;; The value returned by the call to for-each (not illustrated above) can be
;; something arbitrary, such as true.  Give an implementation of for-each.

(ns sicp-mailonline.exercises.2-23)

;; Note that in Scheme the expression part of a cond clause may be a sequence of
;; expressions (i.e. Scheme's cond requires an extra set of brackets, and so a
;; do form is not required to wrap multiple expressions)
(defn for-each-a [proc items]
  (cond (empty? items) true
        :else (do
                (proc (first items))
                (recur proc (rest items)))))

;; a more idiomatic Clojure solution
(defn for-each-b [proc items]
  (doseq [item items]
    (proc item)))

;; another idiomatic Clojure solution - doall is required to force evaluation of
;; the lazy sequence generated by map
(defn for-each-c [proc items]
  (doall (map proc items)))