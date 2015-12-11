# fonticon

## Feature

## How To Use

#### Dipakai dalam ImageView
Dalam MainActivity.class tambahkan code sebagai berikut untuk memanggil method menampilkan font icon.
deklarasikan ImageView :

```
ImageView imgView = (ImageView) findViewById(R.id.imgView);
```
#### dipanggil menggunakan instansiasi class
```
MaterialIcon mi = new MaterialIcon(this)
imgView.setImageDrawable(mi.getDrawable(MainActivity.this,
        getResources().getString(R.string.ic_3d_rotation)));
```

#### dipanggil menggunakan static akses
Icon dapat digunakan sebagai image drawable.
```
imgView.setImageDrawable(MaterialIcon.getDrawable([context],
        [icon name],
        [color name]);
```
#### Contoh cara memanggilnya :

```
imgView.setImageDrawable(MaterialIcon.getDrawable(MainActivity.this,
        getResources().getString(R.string.ic_3d_rotation),
        getResources().getColor(R.color.colorPrimary)));
```
