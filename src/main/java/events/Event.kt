package events

import EliteDangerousAPI

interface Event<T> {
    fun process(json: String, api: EliteDangerousAPI): T
}