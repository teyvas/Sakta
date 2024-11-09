package com.alatoo.sakta;

import java.util.Arrays;
import java.util.List;

public class DatabaseConnection {

    public static List<String> getIncomingHelpRequests() {
        // Simulate fetching help requests from a database
        return Arrays.asList("Patient 1 at 40.7128, -74.0060", "Patient 2 at 40.7306, -73.9352");
    }
}
