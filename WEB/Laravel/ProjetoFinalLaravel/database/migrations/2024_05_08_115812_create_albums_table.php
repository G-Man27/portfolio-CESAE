<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::create('albums', function (Blueprint $table) {
            $table->id();
            $table->string('name');
            $table->string('image_path');
            $table->date('release_date')
            $table->unsignedBigInteger('band_id')->nullable();
            $table->foreign('band_id')->references('id')->on('bands');
            $table->timestamps();
        });

        Schema::create('album_songs', function (Blueprint $table) {
            $table->unsignedBigInteger('album_id');
            $table->foreign('album_id')->references('id')->on('albums');
            $table->unsignedBigInteger('song_id');
            $table->foreign('song_id')->references('id')->on('songs');
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('albums');
        Schema::dropIfExists('album_songs');
    }
};
