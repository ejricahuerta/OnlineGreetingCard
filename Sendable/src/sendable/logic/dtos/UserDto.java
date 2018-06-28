package sendable.logic.dtos;

import java.util.List;

public class UserDto {

	String FullName;
	String Email;
	String HashedPassword;
	AddressDto CurrentAddress;
	CardLetterDto CardLetterDto;
	AccountDto AccountDto;
	String DateAdded;
	List<PaymentDto> Payments;
}
