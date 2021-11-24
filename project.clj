(defproject migratus-test "0.1.0-SNAPSHOT"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [migratus "1.0.1"]
                 [proto-repl "0.3.1"]
                 [org.xerial/sqlite-jdbc "3.36.0.3"]
                 [conman "0.9.1"]
                 [mount "0.1.16"]]
  :plugins [[migratus-lein "0.5.3"]]
  ;:dev-dependencies [[proto-repl "0.3.1"]]
  :main migratus-test.core
  :migratus
  {:store :database
   :migration-dir "migrations/"
   :db "jdbc:sqlite:test_dev.db"}
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
