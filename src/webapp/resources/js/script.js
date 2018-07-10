$(function(){
  jQuery.ajax({
    url: "/realTimeWeatherApp-1.0/resources/properties/app.properties"
  }).done(function(data){
    var options = data.split(/\n/);
    $('select[name="city"]').html('');
    var indiOptions="";
    for (i=0; i<options.length; i++) {
      console.log(options[i].split('='));
      var optionVal = options[i].split('=').pop().replace(';', "");
      indiOptions+='<option value="'+ optionVal +'">'+ optionVal +'</option>';
      console.log(indiOptions);
      $('select[name="city"]').html(indiOptions);
    }
  })
});