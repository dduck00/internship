package com.nts.reservation.service;

import com.nts.reservation.dto.Display;
import com.nts.reservation.dto.DisplayReserve;

public interface DisplayService {
	Display getDisplay(int displayId);

	DisplayReserve getDisplayReservation(int displayId);
}
