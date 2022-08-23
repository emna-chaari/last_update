package com.digitalclick.finalproject.model;

public enum TicketStatus {
    NEW ("New"),
    ASSIGNED ("Assigned"),
    RESOLVED ("Resolved"),
    CLOSED ("Closed");

    private final String name;

    TicketStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public static TicketStatus parse(String value) {
        TicketStatus statusMode = null;
        if (value != null && value.length() != 0) {
            for (TicketStatus current : TicketStatus.values()) {
                if (current.name().equalsIgnoreCase(value)) {
                    statusMode = current;
                    break;
                }
            }
        }
        return statusMode;
    }

}


