package utilities;

public class Payloads {

    public String postChaletsSearchRequestBodyApi(String checkInDate, String checkOutDate) {

        return "{\"searchCriteria\":[{\"lookupTypeId\":2,\"lookupId\":[9]}],\"checkIn\":\"" + checkInDate + "\"," +
                "\"checkOut\":\"" + checkOutDate + "\",\"sortBy\":\"rank\",\"sortOrder\":\"DESC\",\"rankType\":\"dynamic\",\"pageNo\":1,\"pageSize\":10}";
    }
}
