(ns migratus-test.db.migrations.test-migration
  (:require [migratus-test.db.core :as db]
            [migratus.protocols :as proto]))

(defn test-migration [config]
  (println "+test-migration: " config)
  (println "is closed?  " (.isClosed (:connection (:conn config))))
  (proto/disconnect (:db config))
  (println "is closed?  " (.isClosed (:connection (:conn config))))
  (try (db/test-create-test-table! (:connection (:conn config)))
       (catch Exception e (println (str "caught exception " (.getCause e)))))
  (println "-test-migration"))
