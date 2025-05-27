package com.homework.booking.service;

import com.homework.booking.entity.Bill;
import com.homework.booking.entity.Client;
import com.homework.booking.entity.Hotel;
import com.homework.booking.entity.Room;

public class BookingService {

    public void book(Hotel hotel, Client client, int numberOfPerson){
        Room[] rooms = hotel.getRooms();
        boolean isFreeRooms = false;
        for (Room r: rooms){
            if(r.isFree()){
                isFreeRooms = true;
            }
        }
        if(!isFreeRooms){
            System.out.println("Свободных номеров в отеле: " + hotel.getName() + " нет");
        }

        bookRoom(client, numberOfPerson, rooms);
    }

    private static void bookRoom(Client client, int numberOfPerson, Room[] rooms) {
        boolean success = true;
        String clientName = client.getName();
        for(Room room: rooms){
            if(room.getNumberOfPerson() == numberOfPerson){
                 System.out.println("Нашелся номер для пользователя: " + clientName);
                 if (client.getBill().getAmount() >= room.getCost()){
                     Bill clientBill = client.getBill();
                     clientBill.setAmount(clientBill.getAmount() - room.getCost());
                     room.setFree(false);
                     System.out.println("Номер был успешно забранирован клиентом: " + clientName);
                 } else {
                     System.out.println("Не достаточно денег для бронирования номера, клиент: " + clientName);
                 }

             } else {
                 System.out.println("Не нашлось нужного номера пользователя: " + clientName);
             }
        }

        if (!success){
            System.out.println("Не нашлось подходящего номера для клиента: " + clientName);
        }
    }
}
