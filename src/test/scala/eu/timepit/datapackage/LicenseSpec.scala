package eu.timepit.datapackage

import eu.timepit.datapackage.testUtil._
import org.scalacheck.Properties

class LicenseSpec extends Properties(nameOf[License]) {
  property("JSON round-trip") = jsonRoundTrip[License]
  property("JSON decoding error") = jsonDecodeNull[License]
}
