
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import status.GameStatus

fun main(){
    val api = EliteDangerousAPI()
    //api.start()


    val test = jacksonObjectMapper().readValue<GameStatus>("{ \"timestamp\":\"2020-01-20T23:07:26Z\", \"event\":\"Status\", \"Flags\":0 }")
    val test2 = jacksonObjectMapper().readValue<GameStatus>("{ \"timestamp\":\"2020-01-23T14:31:52Z\", \"event\":\"Status\", \"Flags\":150994952, \"Pips\":[4,4,4], \"FireGroup\":0, \"GuiFocus\":0, \"Fuel\":{ \"FuelMain\":5.700000, \"FuelReservoir\":0.299987 }, \"Cargo\":0.000000, \"LegalState\":\"Clean\" }\n")

    print(test.flags)
}