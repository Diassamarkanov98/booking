package com.homework.booking;

import com.homework.booking.entity.Bill;
import com.homework.booking.entity.Client;
import com.homework.booking.entity.Hotel;
import com.homework.booking.entity.Room;
import com.homework.booking.service.BookingService;

//В данном домашнем задании нужно написатьсистему бронировния номеров в отеле.
//Сущности: Client, Hotel, Room, Bill.
//
//Client будет содержать поля: имя, фамилию, номер телефона, почту, ссылку на Bill
//В Bill будет сумма денег
//Hotel будет содеражть поля: имя отеля, список номеров
//Room будет содеражть колличество человек, которых можно разместить, стоимость этого номера и свободен ли этот номер
//
//Сценарии:
//Нужно создать нескольких клиентов с счетами и внести им первоначальную сумму. Так же нужно создать
//        несколько отелей, с разными наборами номеров (В списке внутри сущности Hotel)
//Клиент должен попробовать забронировать номер, для этого он так же указывает
//сколько человек в номере ему нужно разместить. После успешного бронирования списывать сумму со счета клиента.
//
//Так же при бронировании проверять есть ли свободные номера
//
//В одном из сценариев, клиенту должно не хватить денег для бронирования номера
//
//В методе main не нужно проводить никаких операций, кроме создания начальных объектов, сервисов и вызова их методов
public class Main {

    public static void main (String[] args){
        Bill loriBill = new Bill(10000);
        Client loriClient = new Client("Lori", "Cat", "+329841", "lori@cat.xyz", loriBill);
        Bill baxBill = new Bill(12000);
        Client baxClient = new Client("Bax", "Cat", "+123456", "bax@cat.xyz", baxBill);
        Room[] californiaHotelRooms = new Room[]{new Room(1, 1500, true ),
        new Room(3, 3500, true),  };
        Hotel californiaHotel = new Hotel("California", californiaHotelRooms);

        Room[] sanFranciscoRooms = new Room[]{new Room(2,2800,true), new Room(3,400,true), new Room(1,2000,true)};
        Hotel sanFranciscoHotel = new Hotel("SanFrancisco", sanFranciscoRooms);
        BookingService bookingService = new BookingService();
        bookingService.book(californiaHotel, loriClient, 2);
        System.out.println("\n");
        bookingService.book(californiaHotel, loriClient, 4);
        System.out.println("\n");
        bookingService.book(sanFranciscoHotel, baxClient, 3);

    }

}

