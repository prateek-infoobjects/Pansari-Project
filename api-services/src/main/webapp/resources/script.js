// Code goes here
(function($) {
    var routes = {},
      defaultRoute = 'pages';

    routes['pages'] = {
      url: '#/',
      templateUrl: 'resources/views/admin/user.html',
    };

    routes['user'] = {
      url: '#/user',
      templateUrl: 'resources/views/admin/user.html',
    };

    routes['item'] = {
      url: '#/item',
      templateUrl: 'resources/views/admin/item.html',
    };

    routes['store'] = {
      url: '#/store',
      templateUrl: 'resources/views/admin/store.html',
    };

    routes['locationReading'] = {
      url: '#/locationreading',
      templateUrl: 'resources/views/admin/locationreading.html',
    };


    $.router.setData(routes).setDefault(defaultRoute);

    $.when($.ready).then(function() {
      $.router.run('.my-view', 'pages');
    });

  })(jQuery);

  function showLoader() {
    console.log("tests")
    $('#spinnerContainer').removeClass('hidden');
    $('#spinnerContainer').addClass('visible');
  }

  function hideLoader() {
    $('#spinnerContainer').removeClass('visible');
    $('#spinnerContainer').addClass('hidden');
  }
