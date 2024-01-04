public class TCP {
    static class Pair {
        String event;
        String state;

        private Pair(String event, String state) {
            this.event = event;
            this.state = state;
        }

        public static Pair of(String event, String state) {
            return new Pair(event, state);
        }
    }

    private enum State {
        ERROR(Pair.of("", "")),
        CLOSED(Pair.of("APP_PASSIVE_OPEN", "LISTEN"), Pair.of("APP_ACTIVE_OPEN", "SYN_SENT")),
        LISTEN(Pair.of("RCV_SYN", "SYN_RCVD"), Pair.of("APP_SEND", "SYN_SENT"), Pair.of("APP_CLOSE", "CLOSED")),
        SYN_RCVD(Pair.of("APP_CLOSE", "FIN_WAIT_1"), Pair.of("RCV_ACK", "ESTABLISHED")),
        SYN_SENT(Pair.of("RCV_SYN", "SYN_RCVD"), Pair.of("RCV_SYN_ACK", "ESTABLISHED"), Pair.of("APP_CLOSE", "CLOSED")),
        ESTABLISHED(Pair.of("APP_CLOSE", "FIN_WAIT_1"), Pair.of("RCV_FIN", "CLOSE_WAIT")),
        FIN_WAIT_1(Pair.of("RCV_FIN", "CLOSING"), Pair.of("RCV_FIN_ACK", "TIME_WAIT"), Pair.of("RCV_ACK", "FIN_WAIT_2")),
        CLOSING(Pair.of("RCV_ACK", "TIME_WAIT")),
        FIN_WAIT_2(Pair.of("RCV_FIN", "TIME_WAIT")),
        TIME_WAIT(Pair.of("APP_TIMEOUT", "CLOSED")),
        CLOSE_WAIT(Pair.of("APP_CLOSE", "LAST_ACK")),
        LAST_ACK(Pair.of("RCV_ACK", "CLOSED"));

        Pair[] pairs;

        State(Pair... pairs) {
            this.pairs = pairs;
        }

        String handle(String event) {
            for (Pair pair : pairs) {
                if (pair.event.equals(event)) {
                    return pair.state;
                }
            }
            return "ERROR";
        }

        static State lookup(String state) {
            for (State value : values()) {
                if (value.toString().equals(state))
                    return value;
            }
            return ERROR;
        }
    }

    public static String traverseStates(String[] events) {
        State state = State.lookup("CLOSED");
        String output = "ERROR";
        for (String event : events) {
            output = state.handle(event);
            if ("ERROR".equals(output))
                break;
            state = State.lookup(output);
        }
        return output;
    }
}