package com.giulliano.mercado;

import android.app.Application;
import com.giulliano.mercado.modules.ActivityModule;
import dagger.BindsInstance;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by giull on 02/03/2018.
 */

@Singleton
@Component(modules={ActivityModule.class, FragmentModule.class, AppModule.class})
public interface AppComponent {

  @Component.Builder
  interface Builder {
    @BindsInstance
    Builder application(Application application);
    AppComponent build();
  }

  void inject(App app);
}