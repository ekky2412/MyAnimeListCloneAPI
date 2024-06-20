package id.ekky.myanimelist.services;

import id.ekky.myanimelist.dtos.user.UserDetailDTO;
import id.ekky.myanimelist.dtos.user.UserFilterDTO;
import id.ekky.myanimelist.dtos.user.UserListDTO;
import id.ekky.myanimelist.exceptions.EntityNotFoundException;
import id.ekky.myanimelist.repositories.UserRepository;
import id.ekky.myanimelist.utility.DateFormatHelper;
import id.ekky.myanimelist.utility.FormatHelper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserListDTO> getAll(UserFilterDTO dto){
        String username = dto.getUsername() == null || dto.getUsername().isBlank() ? null : dto.getUsername();
        String gender = dto.getGender() == null || dto.getGender().isBlank() ? null : dto.getGender();
        String location = dto.getLocation() == null || dto.getLocation().isBlank() ? null : dto.getLocation();

        int pageSize;
        if (dto.getPage() != null &&
                !FormatHelper.isNumeric(dto.getPage()) &&
                dto.getPage().equals("all")) {
            pageSize = (int) userRepository.count();
        } else {
            pageSize = dto.getPageSize() == null ? 10 : dto.getPageSize();
        }

        int pageNumber = !FormatHelper.isNumeric(dto.getPage()) ? 0 : FormatHelper.toInt(dto.getPage()) - 1;

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return userRepository.findAll(pageable, username, gender, location).map(
                user -> UserListDTO.builder()
                        .id(user.getId())
                        .username(user.getUsername())
                        .gender(user.getGender())
                        .birthday(user.getBirthday() == null ? "" : DateFormatHelper.dateFormat(user.getBirthday()))
                        .location(user.getLocation())
                        .joined(user.getJoined() == null ? "" : DateFormatHelper.dateFormat(user.getJoined()))
                        .build()
        ).toList();
    }

    public UserDetailDTO getDetail(Integer id) {
//        TODO ADD EXCEPTION
        var user = userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("User Id Not Found!")
        );

        return UserDetailDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .gender(user.getGender())
                .birthday(user.getBirthday() == null ? "" : DateFormatHelper.dateFormat(user.getBirthday()))
                .location(user.getLocation())
                .joined(user.getJoined() == null ? "" : DateFormatHelper.dateFormat(user.getJoined()))
                .daysWatched(user.getDaysWatched())
                .meanScore(user.getMeanScore())
                .watching(user.getWatching())
                .completed(user.getCompleted())
                .onHold(user.getOnHold())
                .dropped(user.getDropped())
                .planToWatch(user.getPlanToWatch())
                .totalEntries(user.getTotalEntries())
                .rewatched(user.getRewatched())
                .episodesWatched(user.getEpisodesWatched())
                .build();
    }
}
