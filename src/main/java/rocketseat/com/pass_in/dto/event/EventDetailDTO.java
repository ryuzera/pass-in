package rocketseat.com.pass_in.dto.event;

public record EventDetailDTO(String id, String title, String details, String slug, Integer maximumAttendees, Integer attendeesAmount) {
}
