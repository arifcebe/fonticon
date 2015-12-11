# fonticon

## Feature

## How To Use

#### Dipakai dalam ImageView
Dalam MainActivity.class tambahkan code sebagai berikut untuk memanggil method menampilkan font icon.
deklarasikan ImageView :

```java
ImageView imgView = (ImageView) findViewById(R.id.imgView);
```
#### dipanggil menggunakan instansiasi class
```java
MaterialIcon mi = new MaterialIcon(this)
imgView.setImageDrawable(mi.getDrawable(MainActivity.this,
        getResources().getString(R.string.ic_3d_rotation)));
```

#### dipanggil menggunakan static akses
Icon dapat digunakan sebagai image drawable.
```java
imgView.setImageDrawable(MaterialIcon.getDrawable([context],
        [icon name],
        [color name]);
```
#### Contoh cara memanggilnya :

```java
imgView.setImageDrawable(MaterialIcon.getDrawable(MainActivity.this,
        getResources().getString(R.string.ic_3d_rotation),
        getResources().getColor(R.color.colorPrimary)));
```

#### dipakai pada menu action bar

```java
private void loadIconFont(){
        menu.clear();
        md.setColor(getResources().getColor(R.color.colorAccent));
        
        MenuItem test1 = menu.add("Material Icon").setIcon(
                md.getMenuDrawable(getResources().getString(R.string.ic_account_circle)));
        test1.setShowAsAction( MenuItem.SHOW_AS_ACTION_ALWAYS );

        MenuItem test2 = menu.add("Material Icon").setIcon(
                md.getMenuDrawable(getResources().getString(R.string.ic_account_box)));
        test2.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

    }
    
     @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            //getMenuInflater().inflate(R.menu.menu_main, menu);
            this.menu = menu;
            loadIconFont();
            return true;
        }
```