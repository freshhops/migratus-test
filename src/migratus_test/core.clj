(ns migratus-test.core
  (:require [migratus.core :as migratus]
            [mount.core :as mount]
            [migratus-test.db.core :as db]
            [clojure.java.jdbc :as sql]
            [clojure.java.io :as io]
            [clojure.java.classpath :as cp])
  (:import java.sql.Connection))

(def config
  {:store :database
   :db {:connection-uri "jdbc:sqlite:test_dev.db"}})

(defn parse-ids [args]
  (map #(Long/parseLong %) (rest args)))

(defn -main [& args]
  (mount/start)
  (case (first args)
    "migrate"
    (if (> (count args) 1)
      (apply migratus/up config (parse-ids args))
      (do
        (db/test-create-test-table-two!)
        (migratus/migrate config)))

    "rollback"
    (if (> (count args) 1)
      (apply migratus/down config (parse-ids args))
      (migratus/rollback config))))
