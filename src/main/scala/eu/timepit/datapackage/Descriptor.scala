package eu.timepit.datapackage

import eu.timepit.datapackage.Descriptor.NameType
import eu.timepit.datapackage.types.{DotDashUnderscore, LowerCaseLatinLetter}
import eu.timepit.refined.api.Refined
import eu.timepit.refined.boolean.AnyOf
import eu.timepit.refined.char.Digit
import eu.timepit.refined.collection.Forall
import io.circe.{Decoder, Encoder}
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import io.circe.refined._
import shapeless.::

final case class Descriptor(
    name: NameType,
    resources: List[ResourceInformation],
    license: Option[License] = None,
    title: Option[String] = None,
    description: Option[String] = None,
    homepage: Option[String] = None,
    version: Option[String] = None,
    sources: Option[List[Source]] = None,
    author: Option[Author] = None,
    contributors: Option[List[Author]] = None,
    keywords: Option[List[String]] = None,
    image: Option[String] = None /*
                            dataDependencies: Option[Any] = None,
                            schemas: Option[Any] = None*/
)

object Descriptor {
  type NameType = String Refined Forall[
    AnyOf[LowerCaseLatinLetter :: Digit :: DotDashUnderscore]
  ]

  implicit val decodeDescriptor: Decoder[Descriptor] = deriveDecoder

  implicit val encodeDescriptor: Encoder[Descriptor] = deriveEncoder
}
