function formatTime(time) {
    var date = new Date(time);
    return date.getFullYear() + '-' + (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1);
}