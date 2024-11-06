package com.example.lab9;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ListVFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    private CarViewModel viewModel;
    private TextView titleText;
    private TextView describtionText;
    private TextView priceText;
    private TextView fulldescribtionText;
    private ImageView imageView;

    public ListVFragment() {

    }

    public static ListVFragment newInstance(String param1, String param2) {
        ListVFragment fragment = new ListVFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_gragment, container, false);


        titleText = view.findViewById(R.id.textView5);
        describtionText = view.findViewById(R.id.textView2);
        priceText = view.findViewById(R.id.textView3);
        fulldescribtionText = view.findViewById(R.id.textView4);
        imageView = view.findViewById(R.id.image);

        ListView lvMain = view.findViewById(R.id.lvMain);
        List<Car> cars = Car.getCars();
        ArrayAdapter<Car> adapter = new CarAdapter(requireContext(), R.layout.list_item, cars);
        lvMain.setAdapter(adapter);


        viewModel = new ViewModelProvider(requireActivity()).get(CarViewModel.class);


        viewModel.getSelectedCar().observe(getViewLifecycleOwner(), car -> {
            if (car != null) {
                updateUI(car);
            }
        });

        lvMain.setOnItemClickListener((parent, itemView, position, id) -> {
            Car selectedCar = cars.get(position);
            viewModel.selectCar(selectedCar);
            updateUI(selectedCar);
        });

        return view;
    }

    private void updateUI(Car car) {
        titleText.setText(car.getName());
        describtionText.setText(car.getDescribtion());
        priceText.setText(car.getPrice() + "$");
        fulldescribtionText.setText(car.getFullDescribtion());
        imageView.setImageResource(car.getLogo());
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(getActivity(), "Landscape mode", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(getActivity(), "Portrait mode", Toast.LENGTH_SHORT).show();
        }
    }
}


/*package com.example.lab9;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

public class ListVFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = "ListVFragment";

    private String mParam1;
    private String mParam2;

    TextView titleText;
    TextView describtionText;
    TextView priceText;
    TextView fulldescribtionText;
    ImageView imageView;
    TextView errorText;
    LinearLayout list;
   private String title;
 private    String desccribtion;
   private String fullDescribtion;
    private String price;
    private int  resIdImage;

    private Car car;
    private boolean isSelected = false;

    public ListVFragment() {

    }

    public static ListVFragment newInstance(String param1, String param2) {
        ListVFragment fragment = new ListVFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_gragment, container, false);

        titleText = view.findViewById(R.id.textView5);
        describtionText = view.findViewById(R.id.textView2);
        priceText = view.findViewById(R.id.textView3);
        fulldescribtionText = view.findViewById(R.id.textView4);
        imageView = view.findViewById(R.id.image);

list = view.findViewById(R.id.list);
        ListView lvMain = view.findViewById(R.id.lvMain);
        List<Car> cars = Car.getCars();
        ArrayAdapter<Car> adapter = new CarAdapter(getActivity(), R.id.lvMain, cars);
        lvMain.setAdapter(adapter);

        CarsViewModel viewModel = new ViewModelProvider(this).get(CarsViewModel.class);

        car = viewModel.getCurrentCar();



        Car initialCar = viewModel.getCurrentCar();
        if (initialCar != null) {
            updateUI(initialCar);
        } else {
            Log.w(TAG, "No initial car set in ViewModel");
        }



        if(viewModel.loadCarName()!=null && viewModel.loadCarDescription()!=null &&   viewModel.loadCarFullDescription()!= null ) {

            titleText.setText(viewModel.loadCarName());
            describtionText.setText(viewModel.loadCarDescription());
            fulldescribtionText.setText(viewModel.loadCarFullDescription());
            priceText.setText(viewModel.loadCarPrice()+"$");
            imageView.setImageResource(viewModel.loadCarLogo());
        }





        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Car selectedCar = cars.get(position);


                viewModel.setCurrentCar(selectedCar);

                updateUI(selectedCar);

            }

            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getActivity(), "Nothing selected", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
    private void updateUI(Car car) {
        titleText.setText(car.getName());
        describtionText.setText(car.getDescribtion());
        priceText.setText(car.getPrice() + "$");
        fulldescribtionText.setText(car.getFullDescribtion());
        imageView.setImageResource(car.getLogo());
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {

        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {

        }
    }
}
*/
// ЛАЙВ ДАТА
/*
package com.example.lab9;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;
import androidx.lifecycle.Observer;

import java.util.List;

public class ListVFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = "ListVFragment";

    private String mParam1;
    private String mParam2;

    TextView titleText;
    TextView describtionText;
    TextView priceText;
    TextView fulldescribtionText;
    ImageView imageView;

    public ListVFragment() {

    }

    public static ListVFragment newInstance(String param1, String param2) {
        ListVFragment fragment = new ListVFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


        DataController dataController = DataController.getInstance();
        dataController.getDataScreen1().observe(this, new Observer<Car>() {
            @Override
            public void onChanged(@Nullable Car car) {
                if (car != null) {
                    updateUI(car);
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_gragment, container, false);

        titleText = view.findViewById(R.id.textView5);
        describtionText = view.findViewById(R.id.textView2);
        priceText = view.findViewById(R.id.textView3);
        fulldescribtionText = view.findViewById(R.id.textView4);
        imageView = view.findViewById(R.id.image);

        ListView lvMain = view.findViewById(R.id.lvMain);
        List<Car> cars = Car.getCars();
        ArrayAdapter<Car> adapter = new CarAdapter(getActivity(), R.id.lvMain, cars);
        lvMain.setAdapter(adapter);

        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Car selectedCar = cars.get(position);


                DataController.getInstance().setDataForScreen1(selectedCar);


                updateUI(selectedCar);
            }

            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getActivity(), "Nothing selected", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
    private void updateUI(Car car) {
        titleText.setText(car.getName());
        describtionText.setText(car.getDescribtion());
        priceText.setText(car.getPrice() + "$");
        fulldescribtionText.setText(car.getFullDescribtion());
        imageView.setImageResource(car.getLogo());
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {

        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {

        }
    }
}
*/