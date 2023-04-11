package com.baymart.mapper;

import com.baymart.dto.AddressDto;
import com.baymart.dto.UserDto;
import com.baymart.entity.Address;
import com.baymart.entity.User;
import com.baymart.entity.User.UserBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-11T09:46:07+0530",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 3.33.0.v20230218-1114, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setAddress( addressListToAddressDtoList( user.getAddress() ) );
        userDto.setEmailId( user.getEmailId() );
        userDto.setPassword( user.getPassword() );
        userDto.setPhoneNo( user.getPhoneNo() );
        userDto.setUserId( user.getUserId() );
        userDto.setUserName( user.getUserName() );

        return userDto;
    }

    @Override
    public User toUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        UserBuilder user = User.builder();

        user.address( addressDtoListToAddressList( userDto.getAddress() ) );
        user.emailId( userDto.getEmailId() );
        user.password( userDto.getPassword() );
        user.phoneNo( userDto.getPhoneNo() );
        user.userId( userDto.getUserId() );
        user.userName( userDto.getUserName() );

        return user.build();
    }

    protected AddressDto addressToAddressDto(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDto addressDto = new AddressDto();

        addressDto.setAddressId( address.getAddressId() );
        addressDto.setAddressLine( address.getAddressLine() );
        addressDto.setDistrict( address.getDistrict() );
        addressDto.setPincode( address.getPincode() );
        addressDto.setState( address.getState() );

        return addressDto;
    }

    protected List<AddressDto> addressListToAddressDtoList(List<Address> list) {
        if ( list == null ) {
            return null;
        }

        List<AddressDto> list1 = new ArrayList<AddressDto>( list.size() );
        for ( Address address : list ) {
            list1.add( addressToAddressDto( address ) );
        }

        return list1;
    }

    protected Address addressDtoToAddress(AddressDto addressDto) {
        if ( addressDto == null ) {
            return null;
        }

        Address address = new Address();

        address.setAddressId( addressDto.getAddressId() );
        address.setAddressLine( addressDto.getAddressLine() );
        address.setDistrict( addressDto.getDistrict() );
        address.setPincode( addressDto.getPincode() );
        address.setState( addressDto.getState() );

        return address;
    }

    protected List<Address> addressDtoListToAddressList(List<AddressDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Address> list1 = new ArrayList<Address>( list.size() );
        for ( AddressDto addressDto : list ) {
            list1.add( addressDtoToAddress( addressDto ) );
        }

        return list1;
    }
}
