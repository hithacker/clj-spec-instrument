# clj-spec-instrument

Demos how to autmatically invoke clojure.spec validations at runtime.

## Usage

Run it with `lein run`

## Examples

If you run it with SHOULD_INSTRUMENT enviornment variable false then it will turn off checking of specs automatically on function invocations.

e.g.

`SHOULD_INSTRUMENT=false lein run` .

## License

Copyright © 2017 Hiren Thacker

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
