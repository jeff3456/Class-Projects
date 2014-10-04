################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../ColorWalk.cpp \
../EightProgram.cpp \
../FirstProgram.cpp \
../FlexibleSpaces.cpp \
../FlipFive.cpp \
../HumanCannonball.cpp \
../MixedFractions.cpp \
../NarrowArtGallery.cpp \
../PeskyMosquitoes.cpp \
../Tractor.cpp \
../Units.cpp \
../YikesBikes.cpp 

OBJS += \
./ColorWalk.o \
./EightProgram.o \
./FirstProgram.o \
./FlexibleSpaces.o \
./FlipFive.o \
./HumanCannonball.o \
./MixedFractions.o \
./NarrowArtGallery.o \
./PeskyMosquitoes.o \
./Tractor.o \
./Units.o \
./YikesBikes.o 

CPP_DEPS += \
./ColorWalk.d \
./EightProgram.d \
./FirstProgram.d \
./FlexibleSpaces.d \
./FlipFive.d \
./HumanCannonball.d \
./MixedFractions.d \
./NarrowArtGallery.d \
./PeskyMosquitoes.d \
./Tractor.d \
./Units.d \
./YikesBikes.d 


# Each subdirectory must supply rules for building sources it contributes
%.o: ../%.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


