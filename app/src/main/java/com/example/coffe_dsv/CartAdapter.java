package com.example.coffe_dsv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CartAdapter extends ArrayAdapter<Item> {

    public CartAdapter(Context context, List<Item> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Получаем элемент списка
        Item item = getItem(position);

        // Проверяем, существует ли уже представление для этого элемента
        if (convertView == null) {
            // Если представления нет, создаем его из макета cart_item.xml
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.cart_item, parent, false);
        }

        // Находим TextView, ImageView и Button в макете cart_item.xml
        TextView itemName = convertView.findViewById(R.id.item_name);
        ImageView itemImage = convertView.findViewById(R.id.item_image);
        Button deleteButton = convertView.findViewById(R.id.delete_button);

        // Заполняем TextView и ImageView данными из текущего элемента
        itemName.setText(item.getName());
        itemImage.setImageResource(item.getImageResId());

        // Устанавливаем обработчик нажатия на кнопку удаления
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Удаляем элемент из списка
                remove(item);
                // Обновляем адаптер, чтобы изменения отобразились в списке
                notifyDataSetChanged();
            }
        });

        // Возвращаем полностью заполненное представление элемента списка
        return convertView;
    }
}